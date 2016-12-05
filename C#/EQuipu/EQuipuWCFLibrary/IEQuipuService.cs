using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

using EQuipuWCFLibrary.Modelo;

namespace EQuipuWCFLibrary
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "ILoginService" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    [ServiceKnownType(typeof(Miembro))]
    public interface IEQuipuService
    {
        [OperationContract]
        bool ValidarUsuario(string usuario, string contraseña);

        /* GESTOR MIEMBRO */
        [OperationContract]
        void AgregarMiembro(int codigo, string nombre, string fechaNac, string direccion, string email, char sexo,
                    string selected, int codigoPucp, double craest, int codigoProf, string estado, string dedicacion);
        [OperationContract]
        void ActualizarMiembro(int codigo, string nombre, string fechaNac, string direccion, string email, char sexo,
                    string selected, int codigoPucp, double craest, int codigoProf, string estado, string dedicacion);
        [OperationContract]
        Miembro ObtenerMiembro(int codigo);
        [OperationContract]
        List<Miembro> BuscarMiembro(int codigo, string tipo);
        [OperationContract]
        List<Miembro> ObtenerMiembros();
        [OperationContract]
        void EliminarMiembro(int codigo);

        /* GESTOR EQUIPO */
        [OperationContract]
        Equipo CrearEquipo(string nombre, string interes, string categoria);
        [OperationContract]
        void AgregarEquipo(Equipo objEquipo);
        [OperationContract]
        Equipo ObtenerEquipo(string nombre);
        [OperationContract]
        Equipo ObtenerEquipoConId(int id);
        [OperationContract]
        int NumeroEquipos();
        [OperationContract]
        List<Equipo> BuscarEquipos(string categoria);
        [OperationContract]
        List<Equipo> ObtenerEquipos();
        [OperationContract]
        List<Equipo> BuscarEquiposPorNombre(string nombre);
        [OperationContract]
        void ActualizarEquipo(Equipo objEquipo);
        [OperationContract]
        void AgregarMiembroAEquipo(Equipo e, Miembro m);
        [OperationContract]
        void EliminarEquipo(string nombreEquipo);

        /* GESTOR EVENTOS */
        [OperationContract]
        void AgregarEquipoAEvento(Evento e, Equipo q);
        [OperationContract]
        void AgregarExposicionAEvento(Evento e, Exposicion ex);
        [OperationContract]
        List<Evento> ObtenerEventos();
        [OperationContract]
        Evento CrearEvento(string nombre, string categoria, int numEntradas, double precioEntradas);
        [OperationContract]
        void AgregarEvento(Evento objEvento);
        [OperationContract]
        Evento ObtenerEvento(string nombre);
        [OperationContract]
        List<Evento> BuscarEventos(string nombre);
        [OperationContract]
        List<Evento> BuscarEventosPorCategoria(string categoria);
        [OperationContract]
        void ActualizarEvento(Evento objEvento);
        [OperationContract]
        void EliminarEvento(string nombreEvento);

        /* GESTOR FERIA */
        [OperationContract]
        List<Feria> ObtenerFerias();
        [OperationContract]
        Feria ObtenerFeria(string nombre);
        [OperationContract]
        Feria CrearFeria(string nombre, string fecha);
        [OperationContract]
        void AgregarFeria(Feria objFeria);
        [OperationContract]
        void AgregarEquipoAFeria(Feria f, Equipo e, int i);
        // [OperationContract]
        // Feria ObtenerEventoDeFeria(string nombre);
        [OperationContract]
        void ActualizarFeria(Feria objFeria);

    }

}
