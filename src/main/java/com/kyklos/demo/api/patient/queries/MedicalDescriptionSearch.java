package com.kyklos.demo.api.patient.queries;

import com.kyklos.demo.api.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;

@Repository
public class MedicalDescriptionSearch extends JdbcDaoSupport {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    public MedicalDescriptionSearch(DataSource dataSource) {this.setDataSource(dataSource);}

    @Value("db_example")
    private String schemaName;

    @Value("mySql")
    private String dbVendor;

    public ArrayList<Patient> getPatientByMedicalDescriptionSearch(String MedicalDescription) {
        ArrayList<Patient> list = new ArrayList<>();

        String sql = "SELECT * FROM "+ schemaName +".patient where medical_description LIKE '%"+MedicalDescription+"%'";
        System.out.println(sql);

        list = (ArrayList<Patient>) getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PatientCustomQuery.class));

        return list;
    }
}
