package br.usp.ime.ingpos.modelo.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.util.hibernate.SessionCreator;
import br.usp.ime.ingpos.modelo.RegistroNovoUsuario;

@RequestScoped
@Component
public class RegistroNovoUsuarioDao
    extends
        AbstractDaoImpl<Long,RegistroNovoUsuario>
{
    public RegistroNovoUsuarioDao(
        final SessionCreator sessionCreator )
    {
        super( sessionCreator );
    }

    public RegistroNovoUsuario procurarPorChaveAtivacao(
        final String chaveAtivacao )
    {
        final List<RegistroNovoUsuario> registroNovoUsuarioList = findByCriteria( Restrictions.eq(
            "chaveAtivacao", chaveAtivacao ) );

        if( registroNovoUsuarioList.size() > 1 ) {
            throw new IllegalStateException(
                "Existem dois ou mais registros de novo usu�rio com mesma chave de ativacao: "
                    + chaveAtivacao );
        }

        if( registroNovoUsuarioList.isEmpty() ) {
            return null;
        } else {
            return registroNovoUsuarioList.get( 0 );
        }
    }

    public RegistroNovoUsuario procurarPorEmailOuCpf(
        final String email,
        final String cpf )
    {
        final List<RegistroNovoUsuario> registroNovoUsuarioList = findByCriteria( Restrictions.or(
            Restrictions.eq( "email", email ), Restrictions.eq( "cpf", cpf ) ) );

        if( registroNovoUsuarioList.size() > 1 ) {
            throw new IllegalStateException(
                "Existem dois ou mais registros de novo usuário mesmo cpf: " + cpf + " ou email: "
                    + email );
        }

        if( registroNovoUsuarioList.isEmpty() ) {
            return null;
        } else {
            return registroNovoUsuarioList.get( 0 );
        }
    }
    
    public RegistroNovoUsuario procurarPorEmailOuNome(
            final String email,
            final String nome )
        {
            final List<RegistroNovoUsuario> registroNovoUsuarioList = findByCriteria( Restrictions.or(
                Restrictions.eq( "email", email ), Restrictions.eq( "nomeCompleto", nome ) ) );

            if( registroNovoUsuarioList.size() > 1 ) {
                throw new IllegalStateException(
                    "Existem dois ou mais registros de novo usuário mesmo nome: " + nome + " ou email: "
                        + email );
            }

            if( registroNovoUsuarioList.isEmpty() ) {
                return null;
            } else {
                return registroNovoUsuarioList.get( 0 );
            }
        }
}
