package com.itb.tcc.uniaovoluntaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.uniaovoluntaria.model.ONG;
import com.itb.tcc.uniaovoluntaria.model.Usuario;
import com.itb.tcc.uniaovoluntaria.repository.OngRepository;
import com.itb.tcc.uniaovoluntaria.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private OngRepository ongRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String index(Model model, ONG ong) {
		
		model.addAttribute("ong", ong);
		return "Geral/logon";
	}

	@PostMapping("/login")
	public String login(Model model, ONG ong, Usuario user) {

		Usuario user1 = this.usuarioRepository.Login(user.getNome(), user.getSenha());
		
		ONG user_ong = this.ongRepository.Login(ong.getNome(), ong.getSenha());

		System.out.println(ong.getNome() + ong.getSenha() );
		if(user_ong != null || user1 !=null) {
			return "redirect:/uniao-voluntaria/home";
		}
		
		model.addAttribute("erro", "Usuario ou senha invalidos");
		return "/Geral/logon";
		

		
	}
}
