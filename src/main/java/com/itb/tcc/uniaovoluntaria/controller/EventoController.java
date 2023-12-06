package com.itb.tcc.uniaovoluntaria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itb.tcc.uniaovoluntaria.model.Evento;
import com.itb.tcc.uniaovoluntaria.repository.EventoRepository;

@Controller
@RequestMapping("/uniao-voluntaria/event")
public class EventoController {
	
List<Evento> listEvento = new ArrayList<Evento>();
	
	@Autowired
	private EventoRepository eventoRepository;
	
	private String foto = "";

	public EventoController(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	@GetMapping("/listar-evento")
	public String ListarEvento(Model model) { 
		
		model.addAttribute("evento" , eventoRepository.findAll());
		return "/User/crud-evento";
		
	}
	

	//Carregar o formulario cadastro 
	
	@GetMapping("/novo-evento")
	public String CadastrarUsuario(Evento evento, Model model) {
		model.addAttribute("evento", evento);
		return "/User/novo-evento";
		
	}
	
	
	//Cadastrar (inserir) 
	
	@PostMapping("/add-evento")
	public String gravarUsuario(Evento evento, BindingResult result ,Model model) {
		
		Evento eventoDb = eventoRepository.save(evento);
		evento.setStatusEvento(true);
		return "redirect:/uniao-voluntaria/event/listar-evento";
		
	}
	
	
	@GetMapping("/editar-evento/{id}")
	public String showUpadateform(@PathVariable("id") long id, ModelMap model) {
		Evento evento = eventoRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid evento id: " + id));

		if(evento.getFoto() != null) {
			foto = Base64.getEncoder().encodeToString(evento.getFoto());
		}
		model.addAttribute("evento", evento);
		model.addAttribute("foto", foto);
		return "/User/editar";
	}
	
	@PostMapping("/update/{id}")
	public String atualizarEvento(
		@RequestParam(value = "file", required = false)MultipartFile file, @PathVariable("id") long id,
		@ModelAttribute("evento") Evento evento, BindingResult result){
			if(result.hasErrors()) {
				evento.setId(id);
				return "/User/editar";
			}
			
			if(file != null && !file.getOriginalFilename().isEmpty()) {
				try {
					evento.setFoto(file.getBytes());
				}catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				evento.setFoto(null);
			}
		
		
		eventoRepository.save(evento);
		return "redirect:/uniao-voluntaria/event/listar-evento";
	}
	
	@PostMapping
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
											"You successfully uploaded" + file.getOriginalFilename() + "!");
		return "redirect:/";
		
	}
	
	//Excluir(exclusão fisica)
	
	@GetMapping("/delete/{id}")
	public String deleteEvento(Evento evento,  @PathVariable("id") Long id) {
		eventoRepository.deleteById(id);
		return "redirect:/uniao-voluntaria/event/listar-evento"; 
	}

}
