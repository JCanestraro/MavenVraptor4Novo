package br.edu.unidavi.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unidavi.model.entity.Empresa;
import br.edu.unidavi.model.repository.EmpresaRepository;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.result);
        hash = 89 * hash + Objects.hashCode(this.empresaRepository);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaController other = (EmpresaController) obj;
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.empresaRepository, other.empresaRepository)) {
            return false;
        }
        return true;
    }
    
    
    
}
