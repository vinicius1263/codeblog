package com.spring.codeblog.controller;

import com.spring.codeblog.repository.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

    private PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;

    }

    @GetMapping("/rh/pessoas")
    public String pessoas(Model model){

        model.addAttribute("listaPessoas",pessoaRepository.findAll());

        return "rh/pessoas/index";
    }
}
