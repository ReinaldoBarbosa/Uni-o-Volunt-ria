package com.itb.tcc.uniaovoluntaria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itb.tcc.uniaovoluntaria.model.ONG;
import com.itb.tcc.uniaovoluntaria.model.Usuario;
import com.itb.tcc.uniaovoluntaria.repository.OngRepository;
import com.itb.tcc.uniaovoluntaria.repository.UsuarioRepository;

@Controller
@RequestMapping("/uniao-voluntaria/usuario")
public class UsuarioController {
	List<Usuario> listUsuario = new ArrayList<Usuario>();
	List<ONG> listOng = new ArrayList<ONG>();
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private OngRepository ongRepository;
	
	private String foto = "";

	
	public UsuarioController(UsuarioRepository usuarioRepository, OngRepository ongRepository) {
		this.usuarioRepository = usuarioRepository;
		this.ongRepository = ongRepository;
	}

	
	@GetMapping("/listar-usuario")
	public String ListarUsuario(Model model) {
		
		model.addAttribute("usuario" , usuarioRepository.findAll());
		model.addAttribute("ong" , ongRepository.findAll());
		return "/Adm/crud-user";
		
	}
	
	//Carregar o formulario cadastro 
	
	@GetMapping("/novo-usuario")
	public String CadastrarUsuario(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "/Adm/novo-usuario";
		
	}
	
	
	//Cadastrar (inserir) 
	
	@PostMapping("/add-usuario")
	public String gravarUsuario(Usuario usuario, BindingResult result ,Model model) {
		if(result.hasErrors()) {
			return "/Adm/novo-usuario";
		}
		Usuario usuarioDb = usuarioRepository.save(usuario);
		usuario.setStatus(true);
		return "redirect:/uniao-voluntaria/usuario/listar-usuario";
		
	}
	
	@GetMapping("/todos")
	public List<Usuario> listUsuario(){
		return usuarioRepository.findAll();
		
	}
	
	@GetMapping("/editar-user/{id}")
	public String showUpadateform(@PathVariable("id") long id, ModelMap model) {
		Usuario user = usuarioRepository.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
		if(user.getFoto_perfil() != null) {
			foto = Base64.getEncoder().encodeToString(user.getFoto_perfil());
		}
		model.addAttribute("user", user);
		model.addAttribute("foto", foto);
		return "/Adm/edit-user";
	}
	
	/**
	 * @param file
	 * @param id
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/update/{id}")
	public String atualizarUser(
		@RequestParam(value = "file", required = false)MultipartFile file, @PathVariable("id") long id,
		@ModelAttribute("usuario") Usuario user, BindingResult result){
			if(result.hasErrors()) {
				user.setId(id);
				return "editar";
			}
			
			if(file != null && !file.getOriginalFilename().isEmpty()) {
				try {
					user.setFoto_perfil(file.getBytes());
				}catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				user.setFoto_perfil(null);
			}
		
		
		usuarioRepository.save(user);
		return "redirect:/uniao-voluntaria/usuario/listar-usuario";
	}
	
	@PostMapping
	public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
											"You successfully uploaded" + file.getOriginalFilename() + "!");
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Usuario user, @PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
		return "redirect:/uniao-voluntaria/usuario/listar-usuario";
	}
	
}
 