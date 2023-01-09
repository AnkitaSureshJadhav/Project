using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace CakeShopS
{
    public partial class MDI : Form
    {
        public MDI()
        {
            InitializeComponent();
        }

        private void cakeInformationToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CakeInfo C1 = new CakeInfo();
            C1.ShowDialog();
        }

        private void employeeInformationToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EmpInfo C2 = new EmpInfo();
            C2.ShowDialog();
        }

        private void employeeSalaryToolStripMenuItem_Click(object sender, EventArgs e)
        {
            EmpSal C4 = new EmpSal();
            C4.ShowDialog();
        }

        private void customerBillToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CustBill C5 = new CustBill();
            C5.ShowDialog();
        }

        private void MDI_Load(object sender, EventArgs e)
        {

        }

        private void stockDetailsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StoDet C6 = new StoDet();
            C6.ShowDialog();
        }
    }
}
