package br.ufba.dcc.quartel.forms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.ufba.dcc.quartel.models.Usuario;

public class UsuarioEditForm 
{
	@Min(2)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min=3, max=25)
	private String login;
	
	@NotNull
	@NotEmpty
	@Size(min=3, max=144)
	private String nome;
	
	@Pattern(message="Senha deve conter de 6 à 50 caracteres", regexp="^(\\s*|\\d{6,50})$")
	private String senha;
	
	@Pattern(message="Confirma senha deve conter de 6 à 50 caracteres", regexp="^(\\s*|\\d{6,50})$")
	private String senhaConfirma;
	
	@NotNull
	@NotEmpty
	@Size(min=6, max=144)
	@Email
	private String email;

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getSenha() 
	{
		return senha;
	}

	public void setSenha(String senha) 
	{
		this.senha = senha;
	}

	public String getSenhaConfirma()
	{
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) 
	{
		this.senhaConfirma = senhaConfirma;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public boolean checkSenha()
	{
		return senha.equals(senhaConfirma);
	}
	
	public static UsuarioEditForm factoryUsuarioForm(Usuario usuario)
	{
		UsuarioEditForm usuarioForm = new UsuarioEditForm();
		usuarioForm.setId(usuario.getId());
		usuarioForm.setLogin(usuario.getLogin());
		usuarioForm.setNome(usuario.getNome());
		usuarioForm.setEmail(usuario.getEmail());
		return usuarioForm;
	}
	
	public Usuario generateUsuario()
	{
		Usuario usuario = new Usuario();
		if(id != null) {
			usuario.setId(id);
		}
		usuario.setAtivo(true);
		usuario.setLogin(login);
		if(senha != null) {
			usuario.setSenha(senha);
		}
		usuario.setNome(nome);
		usuario.setEmail(email);
		return usuario;
	}
	
	public static Map<String,String> generateUsuarioSelect(List<Usuario> usuarios)
	{
		Map<String, String> usuarioSelect = new LinkedHashMap<String, String>();
		if(!usuarios.isEmpty()) {
			usuarioSelect.put("0", "Selecione um usuário");
			for (Usuario usuario : usuarios) 
			{
				usuarioSelect.put(usuario.getId().toString(), usuario.getLogin());
			}			
		}
		return usuarioSelect;
	}

	@Override
	public String toString() 
	{
		return "UsuarioForm [id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + ", senhaConfirma="
				+ senhaConfirma + ", email=" + email + "]";
	}
}
