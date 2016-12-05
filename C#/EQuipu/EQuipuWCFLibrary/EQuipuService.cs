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
         * Gestor Miembros
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
            comando.CommandText = String.Format("UPDATE MIEMBRO SET nombre = '{1}', fechaNacimiento = '{2}', direccion = '{3}', email = '{4}', sexo = '{5}' WHERE codigo = {0}",
                codigo, nombre, fechaNac, direccion, email, sexo);
            comando.ExecuteNonQuery();
            if (selected == "Alumno")
            {
                comando.CommandText = String.Format("UPDATE ALUMNO SET codigo_alumno = {1}, craest = {2} WHERE codigo = {0}",
                    codigo, codigoPucp, craest);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Profesor")
            {
                comando.CommandText = String.Format("UPDATE PROFESOR SET codigo_prof = {1}, estado = '{2}' WHERE codigo = {0}",
                    codigo, codigoProf, estado);
                comando.ExecuteNonQuery();
            }
            else if (selected == "Externo")
            {
                comando.CommandText = String.Format("UPDATE EXTERNO SET dedicacion = '{2}' WHERE codigo = {1}",
                    codigo, dedicacion);
                comando.ExecuteNonQuery();
            }
        }

        public List<Miembro> ObtenerMiembros()
        {
            List<Miembro> miembros = new List<Miembro>();
            string query = "select " +
                                "m.*, " +
                                "case when a.codigo_alumno is not NULL then 'alumno' " +
                                    "when p.codigo_prof is not NULL then 'profe' " +
                                    "when e.dedicacion is not NULL then 'externo' " +
                                "end as type, " +
                                "a.codigo_alumno, " +
                                "a.craest, " +
                                "p.codigo_prof, " +
                                "p.estado, " +
                                "e.dedicacion " +
                            "from " +
                                "miembro m " +
                                "left join " +
                                    "alumno a on (m.codigo = a.codigo) " +
                                "left join " +
                                    "profesor p on (m.codigo = p.codigo) " +
                                "left join " +
                                    "externo e on (m.codigo = e.codigo)";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = query;
            MySqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                Miembro u = null;
                if (reader["type"].ToString() == "alumno")
                {
                    u = new Alumno(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        Int32.Parse(reader["codigo_alumno"].ToString()),
                        Double.Parse(reader["craest"].ToString())
                    );
                }
                else if (reader["type"].ToString() == "profe")
                {
                    u = new Profesor(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        Int32.Parse(reader["codigo_prof"].ToString()),
                        reader["estado"].ToString()
                    );
                }
                else if (reader["type"].ToString() == "externo")
                {
                    u = new Externo(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        reader["dedicacion"].ToString()
                    );
                }
                miembros.Add(u);
            }
            return miembros;
        }

        public Miembro ObtenerMiembro(int codigo)
        {

            string query = "select " +
                                "m.*, " +
                                "case when a.codigo_alumno is not NULL then 'alumno' " +
                                    "when p.codigo_prof is not NULL then 'profe' " +
                                    "when e.dedicacion is not NULL then 'externo' " +
                                "end as type, " +
                                "a.codigo_alumno, " +
                                "a.craest, " +
                                "p.codigo_prof, " +
                                "p.estado, " +
                                "e.dedicacion " +
                            "from " +
                                "miembro m " +
                                "left join " +
                                    "alumno a on (m.codigo = a.codigo) " +
                                "left join " +
                                    "profesor p on (m.codigo = p.codigo) " +
                                "left join " +
                                    "externo e on (m.codigo = e.codigo) " +
                            "where " +
                                "m.codigo = {0}";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, codigo);
            MySqlDataReader reader = comando.ExecuteReader();
            Miembro miem = null;
            if (reader.Read())
            {
                if ( reader["type"].ToString() == "alumno" ) 
                {
                    miem = new Alumno(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        Int32.Parse(reader["codigo_alumno"].ToString()),
                        Double.Parse(reader["craest"].ToString())
                    );
                } 
                else if ( reader["type"].ToString() == "profe" ) 
                {
                    miem = new Profesor(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        Int32.Parse(reader["codigo_prof"].ToString()),
                        reader["estado"].ToString()
                    );
                } 
                else if ( reader["type"].ToString() == "externo" ) 
                {
                    miem = new Externo(
                        Int32.Parse(reader["codigo"].ToString()),
                        reader["nombre"].ToString(),
                        reader["fechaNacimiento"].ToString(),
                        reader["direccion"].ToString(),
                        reader["email"].ToString(),
                        reader["sexo"].ToString()[0],
                        reader["dedicacion"].ToString()
                    );
                }
            }
            return miem;
        }

        public List<Miembro> BuscarMiembro(int codigo, string tipo)
        {
            // tipo puede ser "Alumno", "Profesor" o "Externo"
            string query = "SELECT m.*, ";
            switch (tipo)
            {
                case "Alumno":
                    query += "a.codigo_alumno, a.craest FROM miembro m, alumno a ";
                    break;
                case "Profesor":
                    query += "a.codigo_prof, a.estado FROM miembro m, profesor a ";
                    break;
                case "Externo":
                    query += "a.estado FROM miembro m, externo a ";
                    break;
            }
            query += "WHERE m.codigo = a.codigo AND m.codigo = {0}";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, codigo);
            MySqlDataReader reader = comando.ExecuteReader();

            List<Miembro> miembros = new List<Miembro>();

            while (reader.Read())
            {
                Miembro miem = null;
                switch (tipo) {
                    case "Alumno":
                        miem = new Alumno(
                            Int32.Parse(reader["codigo"].ToString()),
                            reader["nombre"].ToString(),
                            reader["fechaNacimiento"].ToString(),
                            reader["direccion"].ToString(),
                            reader["email"].ToString(),
                            reader["sexo"].ToString()[0],
                            Int32.Parse(reader["codigo_alumno"].ToString()),
                            Double.Parse(reader["craest"].ToString())
                        );
                        break;
                    case "Profesor":
                        miem = new Profesor(
                            Int32.Parse(reader["codigo"].ToString()),
                            reader["nombre"].ToString(),
                            reader["fechaNacimiento"].ToString(),
                            reader["direccion"].ToString(),
                            reader["email"].ToString(),
                            reader["sexo"].ToString()[0],
                            Int32.Parse(reader["codigo_prof"].ToString()),
                            reader["estado"].ToString()
                        );
                        break;
                    case "Externo":
                        miem = new Externo(
                            Int32.Parse(reader["codigo"].ToString()),
                            reader["nombre"].ToString(),
                            reader["fechaNacimiento"].ToString(),
                            reader["direccion"].ToString(),
                            reader["email"].ToString(),
                            reader["sexo"].ToString()[0],
                            reader["dedicacion"].ToString()
                        );
                        break;   
                }
                miembros.Add(miem);
            }
            return miembros;
        }

        public void EliminarMiembro(int codigo)
        {

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;

            string query = "DELETE FROM alumno WHERE codigo = {0}";
            comando.CommandText = String.Format(query, codigo);
            comando.ExecuteNonQuery();

            query = "DELETE FROM externo WHERE codigo = {0}";
            comando.CommandText = String.Format(query, codigo);
            comando.ExecuteNonQuery();

            query = "DELETE FROM profesor WHERE codigo = {0}";
            comando.CommandText = String.Format(query, codigo);
            comando.ExecuteNonQuery();

            query = "DELETE FROM miembro WHERE codigo = {0}";
            comando.CommandText = String.Format(query, codigo);
            comando.ExecuteNonQuery();
        }

        /**
         * Gestor Equipos
         */
        public Equipo CrearEquipo(string nombre, string interes, string categoria)
        {
            Equipo e = new Equipo(nombre, interes, categoria);
            return e;
        }

        public void AgregarEquipo(Equipo objEquipo)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("INSERT INTO EQUIPO (nombre, interes, categoria) VALUES ('{0}','{1}','{2}')",
                objEquipo.Nombre, objEquipo.Interes, objEquipo.Categoria);
            comando.ExecuteNonQuery();
        }

        public Equipo ObtenerEquipo(string nombre)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT * FROM EQUIPO WHERE nombre = '{0}'", nombre);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Equipo e = new Equipo(
                    reader["nombre"].ToString(),
                    reader["interes"].ToString(),
                    reader["categoria"].ToString()
                    );
                e.Entradas = Int32.Parse(reader["entradas"].ToString());
                e.Fondo = Double.Parse(reader["fondo"].ToString());

                reader.Close();

                string query = "select me.miembro_id from EQUIPO_X_MIEMBRO me where me.equipo_id = {0}";

                MySqlCommand com2 = new MySqlCommand();
                com2.Connection = _con;
                com2.CommandText = String.Format(query, Int32.Parse(reader["nombre"].ToString()));
                MySqlDataReader read_2 = comando.ExecuteReader();

                while (read_2.Read())
                {
                    Miembro m = this.ObtenerMiembro(Int32.Parse(read_2["miembro_id"].ToString()));
                    e.AddMiembro(m);
                }
                read_2.Close();

                return e;
            }

            return null;
        }

        public int NumeroEquipos()
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT count(*) as num FROM EQUIPO");
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                return Int32.Parse(reader["num"].ToString());
            }
            return -1;
        }

        public List<Equipo> BuscarEquipos(string categoria);
        public List<Equipo> ObtenerEquipos()
        {
            List<Equipo> equipos = new List<Equipo>();
            List<string> lista_equipos = new List<string>();

            string query = "SELECT nombre FROM EQUIPO";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = query;
            MySqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                lista_equipos.Add(reader["nombre"].ToString());
            }
            reader.Close();

            foreach (string n in lista_equipos)
            {
                Equipo e = this.ObtenerEquipo(n);
                equipos.Add(e);
            }

            return equipos;
        }
        public List<Equipo> BuscarEquiposPorNombre(string nombre);
        public void ActualizarEquipo(Equipo objEquipo);
        public void EliminarEquipo(string nombreEquipo);
    }
}
