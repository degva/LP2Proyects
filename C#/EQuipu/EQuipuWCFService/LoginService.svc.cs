﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EQuipuWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "LoginService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select LoginService.svc or LoginService.svc.cs at the Solution Explorer and start debugging.
    public class LoginService : ILoginService
    {
        private List<Usuario> _lista_usuarios;

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