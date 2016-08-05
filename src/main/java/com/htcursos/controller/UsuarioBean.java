package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class UsuarioBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarioList;
	@Inject
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void inicializar(){
		usuarioList = usuarioService.buscarTodos();
	}
	
	public void limpar(){
		usuario = new Usuario();
	}
	
	public void salvar() throws ServiceException{
		usuarioService.salvar(usuario);
		limpar();
		usuarioList = usuarioService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso");
	}
	public void excluir() throws ServiceException{
		usuarioService.excluir(usuario);
		limpar();
		usuarioList = usuarioService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
	}
	
	public void buscarTodos(){
		usuarioService.buscarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}
