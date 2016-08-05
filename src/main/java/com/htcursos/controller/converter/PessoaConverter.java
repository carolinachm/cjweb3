package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.PessoaService;
import com.htcursos.model.service.EstadoService;

@Named
public class PessoaConverter implements Converter {
	@Inject
	private PessoaService pessoaService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try{
			Pessoa pessoa = pessoaService.buscarPorId(Long.parseLong(id));
			return pessoa;
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object pessoa) {
		Pessoa p = (Pessoa) pessoa;
		return p.getId().toString();
	}

}
