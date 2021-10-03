package com.spring.codeblog.iniciaBanco;


import com.spring.codeblog.repository.PessoaRepository;
import com.spring.codeblog.rh.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
@Transactional
public class PopucacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("joao");
        p1.setDataNacimento(LocalDate.of(1990,4,1));
        p1.setEmail("joao@joao");

        Pessoa p2 = new Pessoa("maria");
        p2.setDataNacimento(LocalDate.of(1985,2,19));
        p2.setEmail("maria@maria");

        pessoaRepository.save(p1);
        pessoaRepository.save(p2);
    }
}
