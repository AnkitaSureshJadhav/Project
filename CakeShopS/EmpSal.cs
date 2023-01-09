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
    public partial class EmpSal : Form
    {
        public OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb");
        public EmpSal()
        {
            InitializeComponent();
        }

        private void EmpSal_Load(object sender, EventArgs e)
        {
            FillGridView();
            con.Open();
            OleDbCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = " Select * from EmpInfo ";
            OleDbDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                comboBox1.Items.Add(dr.GetValue(1));
            }
            con.Close();
        }
        private void BtnNew_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (SalID)from EmpSal";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {
                    TxtSalID.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtSalID.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtEmpID.Text = "";
            TxtSalID.Text = "";
            TxtAvailableday.Text = "";
            TxtGrossSal.Text = "";
            dateTimePicker1.Text = "";
            con.Close();

        }

        private void BtnSave_Click(object sender, EventArgs e)
        {


            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "insert into EmpSal values(" + TxtSalID.Text + "," + TxtEmpID.Text + "," + TxtAvailableday.Text + "," + TxtGrossSal.Text + ",'" + dateTimePicker1.Text + "')";
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
            cmd.CommandText = "delete from EmpSal where SalID  =" + TxtSalID.Text + "";
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
            cmd.CommandText = "select * from EmpSal where SalID=" + TxtSalID.Text + "";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                TxtSalID.Text = rd.GetValue(0).ToString();
                TxtEmpID.Text = rd.GetValue(1).ToString();
                TxtAvailableday.Text = rd.GetValue(2).ToString();
                TxtGrossSal.Text = rd.GetValue(3).ToString();
                dateTimePicker1.Text = rd.GetValue(4).ToString();
            }
            con.Close();
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "update EmpSal set SalID =" + TxtSalID.Text + ", EmpID = " + TxtEmpID.Text + ",Avalible Day=" + TxtAvailableday.Text + ",Gross  Salary=" + TxtGrossSal.Text + ",Date=" + dateTimePicker1.Text + " where SalID=" + TxtSalID.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Update ...");
            con.Close();
            FillGridView();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = " Select * from EmpInfo where Name like '" + comboBox1.SelectedItem + "'";
            OleDbDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                TxtEmpID.Text = Convert.ToString(dr.GetValue(0));
                TxtBasicSal.Text = Convert.ToString(dr.GetValue(4));
            }
            con.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            FillGridView();
        }
        void FillGridView()
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select *from EmpSal ";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(dt);
            dataGridView1.DataSource = dt;
            con.Close();
        }

        private void TxtAvailableday_TextChanged(object sender, EventArgs e)
        {
            if (TxtAvailableday.Text.Length > 0)
            {
                TxtGrossSal.Text = (Convert.ToInt32(TxtBasicSal.Text) * Convert.ToInt32(TxtAvailableday.Text) / 30).ToString();
            }
        }

    }
}
