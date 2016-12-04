using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using EQuipu.EQuipuService;

namespace EQuipu.Vista
{
    public partial class frmLogin : Form
    {

        private EQuipuServiceClient equipuService;

        public frmLogin()
        {
            InitializeComponent();
            equipuService = new EQuipuServiceClient();
        }

        private void loginBtn_Click(object sender, EventArgs e)
        {
            if (equipuService.ValidarUsuario(this.usrInput.Text, this.passInput.Text))
            {
                frmPrincipal principal = new frmPrincipal();
                principal.Show();
                equipuService.Close();
                this.Hide();
            }
            else
            {
                MessageBox.Show("huehuehue");
                this.usrInput.Text = "";
                this.passInput.Text = "";
            }
        }

    }
}
