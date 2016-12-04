using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EQuipuWCFLibrary
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "ILoginService" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface IEQuipuService
    {
        [OperationContract]
        bool ValidarUsuario(string usuario, string contraseña);
    }

    [DataContract]
    public class Usuario
    {
        [DataMember]
        private string _username;
        [DataMember]
        private string _password;

        [DataMember]
        public Usuario(string usr, string pass)
        {
            this._username = usr;
            this._password = pass;
        }

        [DataMember]
        public Boolean Validate(string pass)
        {
            return this._password == pass;
        }

        [DataMember]
        public string Username
        {
            get { return _username; }
            set { _username = value; }
        }

        [DataMember]
        public string Password
        {
            get { return _password; }
            set { _password = value; }
        }
    }
}
