package br.edu.unidavi.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unidavi.model.entity.Empresa;
import br.edu.unidavi.model.repository.EmpresaRepository;
import javax.inject.Inject;

@Controller
@Path("/empresa")
public class EmpresaController {

    @Inject
    private Result result;
    @Inject
    private EmpresaRepository empresaRepository;

    @Get
    @Path("/list")
    public void listAll() {
        result.use(Results.json())
                .withoutRoot()
                .from(empresaRepository.list())
                .serialize();
    }

    @Get
    @Path("/gravar")
    public void gravar() {
        Empresa e = new Empresa();
        e.setDocumento(2233333L);
        e.setNome("outra coisa");

        empresaRepository.gravar(e);
    }

    @Get
    @Path("/deletar/{idEmpresa}")
    public void deletar(Long idEmpresa) {
        Empresa e = empresaRepository.findById(idEmpresa);

        empresaRepository.deletar(e);

        System.out.println("Empresa: " + e.getId() + " - " + e.getNome());
    }
}
