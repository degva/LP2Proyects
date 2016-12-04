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
    }

}
