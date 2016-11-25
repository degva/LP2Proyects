using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EQuipuWCFLibrary
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "LoginService" en el código y en el archivo de configuración a la vez.
    public class LoginService : ILoginService
    {
        private List<Usuario> _lista_usuarios;

        public LoginService()
        {
            Usuario u = new Usuario("degva", "123");
            _lista_usuarios = new List<Usuario>();
            _lista_usuarios.Add(u);
        }

        public bool ValidarUsuario(string username, string password)
        {
            Usuario u = BuscarUsuario(username);
            if (u != null)
            {
                return u.Validate(password);
            }
            else
            {
                return false;
            }
        }

        public Usuario BuscarUsuario(string username)
        {
            for (int i = 0; i < _lista_usuarios.Count; i++)
            {
                if (_lista_usuarios[i].Username == username)
                    return _lista_usuarios[i];
            }
            return null;
        }
    }
}
