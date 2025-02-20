namespace LoanAssistant;
using System;
using Microsoft.Maui.Controls;



namespace LoanAssistant
{
    public partial class LoanAssistantPage : ContentPage
    {
        private bool NewPage3 = true;

        public NewPage3()
        {
            InitializeComponent();
        }

        private void ComputeLoan(object sender, EventArgs e)
        {
            double balance, interest, payment;
            int months;
            double monthlyInterest, multiplier;

            if (!double.TryParse(balanceEntry.Text, out balance) || balance <= 0)
            {
                DisplayAlert("Error", "Please enter a valid loan balance.", "OK");
                return;
            }

            if (!double.TryParse(interestEntry.Text, out interest) || interest < 0)
            {
                DisplayAlert("Error", "Please enter a valid interest rate.", "OK");
                return;
            }

            monthlyInterest = interest / 1200;

            if (computePayment)
            {
                if (!int.TryParse(monthsEntry.Text, out months) || months <= 0)
                {
                    DisplayAlert("Error", "Please enter a valid number of payments.", "OK");
                    return;
                }

                multiplier = Math.Pow(1 + monthlyInterest, months);
                payment = balance * monthlyInterest * multiplier / (multiplier - 1);
                paymentEntry.Text = payment.ToString("F2");
            }
            else
            {
                if (!double.TryParse(paymentEntry.Text, out payment) || payment <= 0)
                {
                    DisplayAlert("Error", "Please enter a valid monthly payment.", "OK");
                    return;
                }

                months = (int)((Math.Log(payment) - Math.Log(payment - balance * monthlyInterest)) / Math.Log(1 + monthlyInterest));
                monthsEntry.Text = months.ToString();
            }

            analysisLabel.Text = $"Loan Balance: ${balance:F2}\n" +
                                 $"Interest Rate: {interest:F2}%\n" +
                                 $"Number of Payments: {months}\n" +
                                 $"Monthly Payment: ${payment:F2}";

            computeButton.IsEnabled = false;
            resetButton.IsEnabled = true;
        }

        private void ResetForm(object sender, EventArgs e)
        {
            monthsEntry.Text = "";
            paymentEntry.Text = "";
            analysisLabel.Text = "";
            computeButton.IsEnabled = true;
            resetButton.IsEnabled = false;
        }

        private void ExitApp(object sender, EventArgs e)
        {
            System.Diagnostics.Process.GetCurrentProcess().Kill();
        }
    }
}

	}
}