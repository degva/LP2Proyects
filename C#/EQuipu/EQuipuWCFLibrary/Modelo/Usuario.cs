using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Runtime.Serialization;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    [Serializable]
    public class Usuario
    {
        private string _username;
        private string _password;

        public Usuario(string usr, string pass)
        {
            this._username = usr;
            this._password = pass;
        }

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
