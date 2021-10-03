package com.spring.codeblog.controller;

import com.spring.codeblog.repository.PessoaRepository;
import com.spring.codeblog.rh.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

    @GetMapping("/rh/pessoas/nova")
    public String novaPessoa(@ModelAttribute("pessoa") Pessoa pessoa){
        return "rh/pessoas/form";
    }

    @PostMapping("/rh/pessoas/salvar")
    public  String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa){
     pessoaRepository.save(pessoa);
     return "redirect:/rh/pessoas";
    }

    @GetMapping("/rh/pessoas/{id}")
    public String alterarPessoa(@PathVariable("id") Long id, Model model){

        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);

        if (pessoaOpt.isPresent()){
            model.addAttribute("pessoa",pessoaOpt.get());
        }else {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        return "rh/pessoas/form";
    }

    @GetMapping("/rh/pessoas/excluir/{id}")
    public String deletarPessoa(@PathVariable("id") Long id, Model model){

        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);

        if (pessoaOpt.isPresent()){
            pessoaRepository.delete(pessoaOpt.get());
        }else {
            throw new IllegalArgumentException("Pessoa Invalida");
        }

        return "redirect:/rh/pessoas";
    }
}
