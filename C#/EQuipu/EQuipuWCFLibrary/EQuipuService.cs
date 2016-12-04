using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

using MySql.Data.MySqlClient;
using EQuipuWCFLibrary.Modelo;

namespace EQuipuWCFLibrary
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "LoginService" en el código y en el archivo de configuración a la vez.
    public class EquipuService : IEQuipuService
    {
        private List<Usuario> _lista_usuarios;
        private MySqlConnection _con;

        public EquipuService()
        {
            _con = new MySqlConnection();

            // Claudia's server
            //String pass = "F6700370";
            //_con.ConnectionString = "Server=192.168.200.13;Database=BDLP2_20114297;User=U20114297;Password=" + pass + ";";

            // Gina's server
            String pass = "123456";
            _con.ConnectionString = "Server=192.168.1.46;Database=diegodb;User=diegov;Password=" + pass + ";";


            _con.Open();

            _lista_usuarios = new List<Usuario>();
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
            /*
            MySqlCommand comando = new SqlCommand();
            comando.Connection = _con;
            comando.CommandText = "select * from CICLO_20161_Usuarios";
            SqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                reader['nombredelacolumna']
            }
             */

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = "SELECT * FROM USERS WHERE username = {1}";
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Usuario u = new Usuario(reader["username"].ToString(), reader["password"].ToString());
                return u;
            }

            return null;
        }
    }
}
