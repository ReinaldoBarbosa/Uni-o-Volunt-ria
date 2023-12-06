package com.itb.tcc.uniaovoluntaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.uniaovoluntaria.repository.EventoRepository;

@Controller
@RequestMapping("/uniao-voluntaria")
public class IndexController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public IndexController(EventoRepository eventoRpository) {
		this.eventoRepository = eventoRepository;
		
	}
	
	@GetMapping("/index")
	public String index() {
		return "/Geral/index";
	}
	
	@GetMapping("/voluntario")
	public String voluntarioPage() {
		return "/Geral/souVoluntario";
	}
	
	@GetMapping("/ong")
	public String ongPage() {
		return "/Geral/souOng";
	}
	
	@GetMapping("/login")
	public String loginPage(){
		return "/Geral/logon";
	}
	
	@GetMapping("/cadastro")
	public String cadastroPage(){
		return "redirect:/ong/nova-ong";
	}
	
	
	@GetMapping("/redefinir-senha")
	public String redefinirSenhaPage(){
		return "/Geral/RedefinirSenha";
	}
	
	@GetMapping("/esqueci-senha")
	public String esqueciSenhaPage(){
		return "/Geral/EsqueceuSenha";
	}
	
	@GetMapping("/home")
	public String homePage(Model model){
		model.addAttribute("evento" , eventoRepository.findAll());
		return "/User/home";
	}
	
	@GetMapping("/evento")
	public String evetoPage(){
		return "redirect:/uniao-voluntaria/event/listar-evento";
	}
	
	@GetMapping("/pedido")
	public String pedidoPage(){
		return "/User/pedido";
	}
	
	@GetMapping("/user")
	public String userPage(){
		return "/User/View_Voluntario";
	}
	
	
	@GetMapping("/perfil")
	public String perfilPage(){
		return "/User/tela1";
	}
	
	@GetMapping("/view-evento")
	public String viewEvento(){
		return "/User/View-Evento";
	}
	
	
	
	@GetMapping("/contact")
	public String contactPage(){
		return "/User/contact";
	}
}
