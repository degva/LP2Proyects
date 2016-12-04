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
    public interface IEQuipuService
    {
        [OperationContract]
        bool ValidarUsuario(string usuario, string contraseña);
    }

}
