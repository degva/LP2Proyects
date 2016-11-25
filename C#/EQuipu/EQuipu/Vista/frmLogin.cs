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

        private LoginServiceClient loginService;

        public frmLogin()
        {
            InitializeComponent();
            loginService = new LoginServiceClient();
        }

        private void loginBtn_Click(object sender, EventArgs e)
        {
            if (loginService.ValidarUsuario(this.usrInput.Text, this.passInput.Text))
            {
                frmPrincipal principal = new frmPrincipal();
                principal.Show();
                loginService.Close();
                this.Hide();
            }
            else
            {
                MessageBox.Show("huehuehue");
                this.usrInput.Text = "";
                this.passInput.Text = "";
            }
        }

        private void cancelBtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
