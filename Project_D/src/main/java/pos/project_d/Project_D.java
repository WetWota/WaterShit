/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pos.project_d;

import java.util.List;
import pos.project_d.Data.AccountData;

public class Project_D {
    public static void main(String[] args) {
        
        AccountData accountData = new AccountData();
        List<AccountData.Account> accounts = accountData.getAccounts();
        
        //display dashboard
        Dashboard yes = new Dashboard();
        yes.setVisible(true);
        
    }
}
