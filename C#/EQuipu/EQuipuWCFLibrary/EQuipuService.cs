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
            _con.ConnectionString = "Server=localhost;Database=degvadb;User=degva;Password=" + pass + ";";

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
            reader.Close();

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
            reader.Close();
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
            reader.Close();
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
            reader.Close();
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

            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT id FROM EQUIPO WHERE nombre = '{0}'", objEquipo.Nombre);

            MySqlDataReader reader = comando.ExecuteReader();
            List<Miembro> miembros = new List<Miembro>();

            if (reader.Read())
            {
                objEquipo.Id = Int32.Parse(reader["id"].ToString());
            }
            reader.Close();
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
                    Int32.Parse(reader["id"].ToString()),
                    reader["nombre"].ToString(),
                    reader["interes"].ToString(),
                    reader["categoria"].ToString()
                    );
                e.Entradas = Int32.Parse(reader["entradas"].ToString());
                e.Fondo = Double.Parse(reader["fondo"].ToString());

                int equipo_id = Int32.Parse(reader["id"].ToString());
                reader.Close();

                string query = "select miembro_id from EQUIPO_X_MIEMBRO where equipo_id = {0}";

                MySqlCommand com2 = new MySqlCommand();
                com2.Connection = _con;
                com2.CommandText = String.Format(query, equipo_id);
                MySqlDataReader read_2 = com2.ExecuteReader();

                List<int> lista_miembros = new List<int>();

                while (read_2.Read())
                {
                    lista_miembros.Add(Int32.Parse(read_2["miembro_id"].ToString()));
                }
                read_2.Close();

                foreach (int id in lista_miembros)
                {
                    Miembro m = this.ObtenerMiembro(id);
                    e.AddMiembro(m);
                }

                return e;
            }
            else
            {
                reader.Close();
            }

            return null;
        }

        public Equipo ObtenerEquipoConId(int id)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT * FROM EQUIPO WHERE id = {0}", id);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Equipo e = new Equipo(
                    Int32.Parse(reader["id"].ToString()),
                    reader["nombre"].ToString(),
                    reader["interes"].ToString(),
                    reader["categoria"].ToString()
                    );
                e.Entradas = Int32.Parse(reader["entradas"].ToString());
                e.Fondo = Double.Parse(reader["fondo"].ToString());

                int equipo_id = Int32.Parse(reader["id"].ToString());
                reader.Close();

                string query = "select miembro_id from EQUIPO_X_MIEMBRO where equipo_id = {0}";

                MySqlCommand com2 = new MySqlCommand();
                com2.Connection = _con;
                com2.CommandText = String.Format(query, equipo_id);
                MySqlDataReader read_2 = com2.ExecuteReader();

                List<int> lista_miembros = new List<int>();

                while (read_2.Read())
                {
                    lista_miembros.Add(Int32.Parse(read_2["miembro_id"].ToString()));
                }
                read_2.Close();

                foreach (int rcv in lista_miembros)
                {
                    Miembro m = this.ObtenerMiembro(rcv);
                    e.AddMiembro(m);
                }

                return e;
            }
            else
            {
                reader.Close();
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
            reader.Close();
            return -1;
        }

        public List<Equipo> BuscarEquipos(string categoria)
        {
            List<Equipo> equipos = new List<Equipo>();
            List<string> lista_equipos = new List<string>();

            string query = "SELECT nombre FROM EQUIPO WHERE categoria = '{0}'";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, categoria);
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

        public List<Equipo> BuscarEquiposPorNombre(string nombre)
        {
            List<Equipo> equipos = new List<Equipo>();
            List<string> lista_equipos = new List<string>();

            string query = "SELECT nombre FROM EQUIPO WHERE nombre LIKE '%{0}%'";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombre);
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

        public void ActualizarEquipo(Equipo objEquipo)
        {
            string query = "UPDATE EQUIPO SET nombre = '{0}', interes = '{1}', categoria = '{2}', fondo = {3}, entradas = {4} WHERE id = {5}";
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, objEquipo.Nombre, objEquipo.Interes, objEquipo.Categoria, objEquipo.Fondo, objEquipo.Entradas, objEquipo.Id);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM EQUIPO_X_MIEMBRO WHERE equipo_id = {0}";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, objEquipo.Id);
            comando.BeginExecuteNonQuery();

            foreach (Miembro m in objEquipo.ListaMiembros)
            {
                query = "INSERT INTO EQUIPO_X_MIEMBRO (equipo_id, miembro_id) VALUES ({0}, {1})";
                comando = new MySqlCommand();
                comando.Connection = _con;
                comando.CommandText = String.Format(query, objEquipo.Id, m.Codigo);
                comando.BeginExecuteNonQuery();
            }
        }

        public void EliminarEquipo(string nombreEquipo)
        {
            string query = "DELETE FROM EQUIPO_X_MIEMBRO WHERE equipo_id = (SELECT id FROM EQUIPO WHERE nombre = '{0}')";
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombreEquipo);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM EQUIPO WHERE nombre = '{0}'";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombreEquipo);
            comando.BeginExecuteNonQuery();
        }

        public void AgregarMiembroAEquipo(Equipo e, Miembro m)
        {
            e.AddMiembro(m);
        }

        /**
         * GESTOR EVENTOS
         */
        
        public void AgregarEquipoAEvento(Evento e, Equipo q)
        {
            e.AgregarEquipo(q);
        }
        
        public void AgregarExposicionAEvento(Evento e, Exposicion ex)
        {
            e.AgregarExposicion(ex);
        }

        public List<Evento> ObtenerEventos()
        {
            List<Evento> eventos = new List<Evento>();
            List<string> lista_equipos = new List<string>();

            string query = "SELECT nombre FROM EVENTO";

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
                Evento e = this.ObtenerEvento(n);
                eventos.Add(e);
            }

            return eventos;
        }

        public Evento CrearEvento(string nombre, string categoria, int numEntradas, double precioEntradas)
        {
            Evento e = new Evento(nombre, categoria, numEntradas, precioEntradas);
            return e;
        }

        public void AgregarEvento(Evento e)
        {

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("INSERT INTO EVENTO (nombre, categoria, num_entradas, precio_entrada) VALUES ('{0}','{1}',{2},{3})",
                e.Nombre, e.CategoriaEquipo, e.NumEntradas, e.PrecioEntrada);
            comando.ExecuteNonQuery();

            /*
             * Aca deberia haber codigo para agregar a los equipos en ese evento asi tambien como
             * a las exposiciones de ese evento
             */
        }

        public Evento ObtenerEvento(string nombre)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT * FROM EVENTO WHERE nombre = '{0}'", nombre);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Evento e = new Evento(
                    reader["nombre"].ToString(),
                    reader["categoria"].ToString(),
                    Int32.Parse(reader["num_entradas"].ToString()),
                    Double.Parse(reader["precio_entrada"].ToString())
                    );

                string nom = reader["nombre"].ToString();
                reader.Close();

                string query = "select equipo_id from equipo_x_evento where evento_nombre = '{0}'";

                MySqlCommand com2 = new MySqlCommand();
                com2.Connection = _con;
                com2.CommandText = String.Format(query, nom);
                MySqlDataReader read_2 = com2.ExecuteReader();

                List<int> lista_equipos = new List<int>();

                while (read_2.Read())
                {
                    lista_equipos.Add(Int32.Parse(read_2["equipo_id"].ToString()));
                }
                read_2.Close();

                foreach (int id in lista_equipos)
                {
                    Equipo eq = this.ObtenerEquipoConId(id);
                    this.AgregarEquipoAEvento(e, eq);
                }

                return e;
            }
            else
            {
                reader.Close();
            }

            return null;
        }

        public List<Evento> BuscarEventos(string nombre)
        {
            List<Evento> eventos = new List<Evento>();
            List<string> lista_eventos = new List<string>();

            string query = "SELECT nombre FROM EVENTO WHERE nombre LIKE '%{0}%'";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombre);
            MySqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                lista_eventos.Add(reader["nombre"].ToString());
            }
            reader.Close();

            foreach (string n in lista_eventos)
            {
                Evento e = this.ObtenerEvento(n);
                eventos.Add(e);
            }

            return eventos;
        }

        public List<Evento> BuscarEventosPorCategoria(string categoria)
        {
            List<Evento> eventos = new List<Evento>();
            List<string> lista_eventos = new List<string>();

            string query = "SELECT nombre FROM EVENTO WHERE categoria = '{0}'";

            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, categoria);
            MySqlDataReader reader = comando.ExecuteReader();
            while (reader.Read())
            {
                lista_eventos.Add(reader["nombre"].ToString());
            }
            reader.Close();

            foreach (string n in lista_eventos)
            {
                Evento e = this.ObtenerEvento(n);
                eventos.Add(e);
            }

            return eventos;
        }

        public void ActualizarEvento(Evento ev)
        {
            string query = "UPDATE EVENTO SET categoria = '{0}', num_entradas = '{1}', precio_entrada = {2} WHERE nombre = {3}";
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, ev.CategoriaEquipo, ev.NumEntradas, ev.PrecioEntrada, ev.Nombre);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM equipo_x_evento WHERE evento_nombre = {0}";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, ev.Nombre);
            comando.BeginExecuteNonQuery();

            foreach (Equipo eq in ev.Equipos)
            {
                query = "INSERT INTO equipo_x_evento (evento_nombre, equipo_id) VALUES ({0}, {1})";
                comando = new MySqlCommand();
                comando.Connection = _con;
                comando.CommandText = String.Format(query, ev.Nombre, eq.Id);
                comando.BeginExecuteNonQuery();
            }

            query = "DELETE FROM exposicion_x_evento WHERE evento_nombre = {0}";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, ev.Nombre);
            comando.BeginExecuteNonQuery();

            foreach (Exposicion ex in ev.Exposiciones)
            {
                query = "INSERT INTO exposicion_x_evento (evento_nombre, exposicion_id) VALUES ({0}, {1})";
                comando = new MySqlCommand();
                comando.Connection = _con;
                comando.CommandText = String.Format(query, ev.Nombre, ex.Id);
                comando.BeginExecuteNonQuery();
            }
        }

        public void EliminarEvento(string nombreEvento)
        {
            string query = "DELETE FROM exposicion_x_evento WHERE evento_nombre = '{0}'";
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombreEvento);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM EQUIPO_X_MIEMBRO WHERE evento_nombre = '{0}'";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombreEvento);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM EVENTO WHERE nombre = '{0}'";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, nombreEvento);
            comando.BeginExecuteNonQuery();
        }

        /**
         * GESTOR FERIA
         */
        public List<Feria> ObtenerFerias()
        {
            List<Feria> ferias = new List<Feria>();
            List<string> lista_equipos = new List<string>();

            string query = "SELECT nombre FROM FERIAS";

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
                Feria e = this.ObtenerFeria(n);
                ferias.Add(e);
            }

            return ferias;
        }

        public Feria ObtenerFeria(string nombre) {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("SELECT * FROM FERIA WHERE nombre = '{0}'", nombre);
            MySqlDataReader reader = comando.ExecuteReader();
            if (reader.Read())
            {
                Feria f = new Feria(
                    reader["nombre"].ToString(),
                    reader["fecha"].ToString()
                    );

                string nom = reader["nombre"].ToString();
                reader.Close();

                string query = "select equipo_id from feria_x_equipos where nombre_feria = {0}";

                MySqlCommand com2 = new MySqlCommand();
                com2.Connection = _con;
                com2.CommandText = String.Format(query, nom);
                MySqlDataReader read_2 = com2.ExecuteReader();

                List<int> lista_equipos = new List<int>();

                while (read_2.Read())
                {
                    lista_equipos.Add(Int32.Parse(read_2["equipo_id"].ToString()));
                }
                read_2.Close();

                foreach (int id in lista_equipos)
                {
                    Equipo eq = this.ObtenerEquipoConId(id);
                    f.Equipos.Add(eq);
                }

                return f;
            }
            else
            {
                reader.Close();
            }

            return null;
        }

        public Feria CrearFeria(string nombre, string fecha)
        {
            Feria f = new Feria(nombre, fecha);
            return f;
        }

        public void AgregarFeria(Feria objFeria)
        {
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format("INSERT INTO FERIA (nombre, fecha) VALUES ('{0}','{1}')",
                objFeria.Nombre, objFeria.Fecha);
            comando.ExecuteNonQuery();
        }

        /*
        public Feria ObtenerEventoDeFeria(string nombre)
        {
            Feria objFeria = null;
            for (int i = 0; i < this._ferias.Count; i++)
            {
                if (this._ferias[i].Nombre == nombre)
                {
                    objFeria = this._ferias[i];
                    break;
                }
            }
            return objFeria;
        }
         */

        public void AgregarEquipoAFeria(Feria f, Equipo e, int i)
        {
            f.AddEquipo(e,i);
        }

        public void ActualizarFeria(Feria ev)
        {
            string query = "UPDATE FERIA SET fecha = '{0}' WHERE nombre = {1}";
            MySqlCommand comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, ev.Fecha, ev.Nombre);
            comando.BeginExecuteNonQuery();

            query = "DELETE FROM feria_x_equipos WHERE evento_nombre = {0}";
            comando = new MySqlCommand();
            comando.Connection = _con;
            comando.CommandText = String.Format(query, ev.Nombre);
            comando.BeginExecuteNonQuery();

            foreach (Equipo eq in ev.Equipos)
            {
                query = "INSERT INTO feria_x_equipos (nombre_feria, equipo_id) VALUES ({0}, {1})";
                comando = new MySqlCommand();
                comando.Connection = _con;
                comando.CommandText = String.Format(query, ev.Nombre, eq.Id);
                comando.BeginExecuteNonQuery();
            }
        }
    }
}
