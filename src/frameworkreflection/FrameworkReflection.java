package frameworkreflection;

import com.gc.atividade.frameworkreflection.DAO.OrmDAO;

import com.gc.atividade.frameworkreflection.model.Conta;
import com.gc.atividade.frameworkreflection.model.Pessoa;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class FrameworkReflection {

    public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class<Conta> classeConta = Conta.class;
        Class<Pessoa> classePessoa = Pessoa.class;
        OrmDAO dao = new OrmDAO();

        Conta conta = new Conta(null, "2500", 0, 2.0);
        Pessoa pessoa = new Pessoa(1, "michael alves", "22", "testando o texto :)");

//metodos toString referentes a cada objeto instanciado
        String Strconta = conta.toString();
        String StrPessoa = pessoa.toString();

//        dao.createTable(classePessoa);;
//        dao.createTable(classeConta);
//        dao.save(classePessoa, StrPessoa);
//        dao.save(classePessoa, StrPessoa);
//        dao.Update(classeConta, "teste", 2, "13");
//        dao.findListAll(classePessoa);
//        dao.findById(classePessoa,2);
//        dao.delete(classePessoa,1);
        
    }

}
