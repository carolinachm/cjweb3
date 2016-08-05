package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Permissao;
import com.htcursos.model.service.PermissaoService;


@Named
public class PermissaoConverter implements Converter {
	@Inject
	private PermissaoService permissaoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try{
			Permissao permissao = permissaoService.buscarPorId(Long.parseLong(id));
			return permissao;
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object permissao) {
		Permissao c = (Permissao) permissao;
		return c.getId().toString();
	}

}
