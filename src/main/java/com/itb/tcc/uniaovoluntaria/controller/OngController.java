package com.itb.tcc.uniaovoluntaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.uniaovoluntaria.model.Evento;
import com.itb.tcc.uniaovoluntaria.model.ONG;
import com.itb.tcc.uniaovoluntaria.repository.OngRepository;

@Controller
@RequestMapping("/ong")
public class OngController {
	List<ONG> listOng = new ArrayList<ONG>();
	
	@Autowired
	private OngRepository ongRepository;
	
	private String foto = "";
	
	public OngController(OngRepository ongRepository){
		this.ongRepository = ongRepository;
	}
	
	@GetMapping("/nova-ong")
	public String CadastrarOng(ONG ong, Model model) {
		model.addAttribute("ong", ong);
		return "Geral/cadastrar";
		
	}
	
	//Cadastrar (inserir) 
	
	@PostMapping("/add-ong")
	public String gravarUsuario(ONG ong, BindingResult result ,Model model) {
		
		if(result.hasErrors()) {
			return "Geral/cadastra";
		}

		ONG ongDb = ongRepository.save(ong);
		ong.setStatusONG(true);
		return "redirect:/uniao-voluntaria/login";
		
	}
}
 