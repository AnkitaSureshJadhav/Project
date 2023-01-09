using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace CakeShopS
{
    public partial class EmpInfo : Form
    {
        public OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb");
        public EmpInfo()
        {
            InitializeComponent();
        }


        private void BtnNew_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (EmpID)from EmpInfo";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {
                    TxtEmpID.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtEmpID.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtName.Text = "";
            TxtEmpAdd.Text = "";
            TxtEmpCon.Text = "";
            TxtBasicSal.Text = "";
            con.Close();
        }

        private void BtnSave_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "insert into EmpInfo values(" + TxtEmpID.Text + ",'" + TxtName.Text + "','" + TxtEmpAdd.Text + "','" + TxtEmpCon.Text + "','" + TxtBasicSal.Text + "')";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Saved");
            con.Close();
            FillGridView();
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " delete from EmpInfo where EmpID =" + TxtEmpID.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data deleted successfully");
            con.Close();
            FillGridView();
        }

        private void BtnSearch_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select * from EmpInfo where EmpID=" + TxtEmpID.Text + "";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                TxtEmpID.Text = rd.GetValue(0).ToString();
                TxtName.Text = rd.GetValue(1).ToString();
                TxtEmpAdd.Text = rd.GetValue(2).ToString();
                TxtEmpCon.Text = rd.GetValue(3).ToString();
                TxtBasicSal.Text = rd.GetValue(4).ToString();
            }
            con.Close();
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "update EmpInfo set EmpID =" + TxtEmpID.Text + ",Name ='" + TxtName.Text + "',Address='" + TxtEmpAdd.Text + ",Contact No=" + TxtEmpCon.Text + ",Basic Salary=" + TxtBasicSal.Text + " where EmpID=" + TxtEmpID.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Update ...");
            con.Close();
            FillGridView();
        }

        private void EmpInfo_Load(object sender, EventArgs e)
        {
            FillGridView();
        }
        void FillGridView()
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select *from EmpInfo ";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(dt);
            dataGridView1.DataSource = dt;
            con.Close();
        }
    }
}
