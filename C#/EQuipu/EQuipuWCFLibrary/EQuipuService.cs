using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

using MySql.Data.MySqlClient;

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

            String pass = "F6700370";
            _con.ConnectionString = "Server=192.168.200.13;Database=BDLP2_20114297;User=U20114297;Password=" + pass + ";";
            _con.Open();

            /* Para usar la conexion de la base de datos
            SqlCommand comando = new SqlCommand();
            comando.Connection = conexion;
            comando.CommandText = "select * from CICLO_20161_Usuarios";
            SqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                reader['nombredelacolumna']
            }
             */


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
            for (int i = 0; i < _lista_usuarios.Count; i++)
            {
                if (_lista_usuarios[i].Username == username)
                    return _lista_usuarios[i];
            }
            return null;
        }
    }
}
