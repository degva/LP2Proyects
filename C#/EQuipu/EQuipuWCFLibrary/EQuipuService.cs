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

        /*
         * User Management
         */
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
            comando.CommandText = String.Format("SELECT * FROM USERS WHERE username = '{0}'", username);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Usuario u = new Usuario(reader["username"].ToString(), reader["password"].ToString());
                return u;
            }

            return null;
        }

        /**
         * Miembros Management
         */
        public void AgregarMiembro(int codigo, string nombre, string fechaNac, string direccion, string email, char sexo,
                    string selected, int codigoPucp, double craest, int codigoProf, string estado, string dedicacion)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("INSERT INTO MIEMBRO (codigo, nombre, fechaNacimiento, direccion, email, sexo) VALUES ({0},'{1}','{2}','{3}','{4}','{5}')", 
                codigo, nombre, fechaNac, direccion, email, sexo);
            comando.ExecuteNonQuery();
            if (selected == "Alumno")
            {
                comando.CommandText = String.Format("INSERT INTO ALUMNO (codigo, codigo_alumno, craest) VALUES ({0},{1},{2})",
                    codigo, codigoPucp, craest);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Profesor")
            {
                comando.CommandText = String.Format("INSERT INTO PROFESOR (codigo, codigo_prof, estado) VALUES ({0},{1},'{2}')",
                    codigo, codigoProf, estado);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Externo")
            {
                comando.CommandText = String.Format("INSERT INTO EXTERNO (codigo, dedicacion) VALUES ({0},'{1}')",
                    codigo, dedicacion);
                comando.ExecuteNonQuery();
            }
            
        }

        public void ActualizarMiembro(int codigo, string nombre, string fechaNac, string direccion, string email, char sexo,
                    string selected, int codigoPucp, double craest, int codigoProf, string estado, string dedicacion)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("UPDATE MIEMBRO SET (nombre, fechaNacimiento, direccion, email, sexo) = ('{1}','{2}','{3}','{4}','{5}') WHERE codigo = {0}",
                codigo, nombre, fechaNac, direccion, email, sexo);
            comando.ExecuteNonQuery();
            if (selected == "Alumno")
            {
                comando.CommandText = String.Format("UPDATE ALUMNO SET (codigo_alumno, craest) = ({1},{2}) WHERE codigo = {0}",
                    codigo, codigoPucp, craest);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Profesor")
            {
                comando.CommandText = String.Format("UPDATE PROFESOR SET (codigo_prof, estado) = ({1},'{2}') WHERE codigo = {0}",
                    codigo, codigoProf, estado);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Externo")
            {
                comando.CommandText = String.Format("UPDATE EXTERNO SET (dedicacion) = ('{2}') WHERE codigo = {1}",
                    codigo, dedicacion);
                comando.ExecuteNonQuery();
            }
        }


        public List<Miembro> ObtenerMiembros()
        {
            return null;
        }

        public Miembro ObtenerMiembro(int codigo)
        {

            string query = "select " +
                                "m.*," +
                                "case " +
                                "a.codigoPucp, a.craest," +
                                "p.codigoProfe, p.estado," +
                                "e.dedicacion " +
                            "from " +
                                "miembro m " +
                                "left join " +
                                    "alumno a on m.codigo = a.miembro_codigo " +
                                "left join " +
                                    "profesor p on m.codigo = p.miembro_codigo " +
                                "left join " +
                                    "externo e on m.codigo = e.miembro_codigo " +
                            "where " +
                                "m.codigo = {0}";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, codigo);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                /* TODO */
                Usuario u = new Miembro();
                return u;
            }
            return null;
        }
        public List<Miembro> BuscarMiembro(int codigo, string tipo)
        {
            return null;
        }

        public void EliminarMiembro(int codigo)
        {
        }
    }
}
