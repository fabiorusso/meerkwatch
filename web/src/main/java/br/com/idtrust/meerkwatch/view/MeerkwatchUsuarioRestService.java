package br.com.idtrust.meerkwatch.view;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.idtrust.meerkwatch.controller.UsuarioController;
import br.com.idtrust.meerkwatch.model.Usuario;

@Path("/usuarios")
public class MeerkwatchUsuarioRestService {

	@Inject
	private UsuarioController usuarioController;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return usuarioController.visualizarUsuarios();
	}

	@POST
	public Response cadastrarUsuario(Usuario usuario) {
		try {
			usuarioController.cadastrarUsuario(usuario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@DELETE
	public Response desativarUsuario(Usuario usuario) {
		try {
			usuarioController.desativarUsuario(usuario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

}
