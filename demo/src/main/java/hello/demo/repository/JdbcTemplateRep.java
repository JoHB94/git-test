package hello.demo.repository;

import hello.demo.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Repository
public class JdbcTemplateRep implements MemberRepository{

    private final JdbcTemplate db;

    public JdbcTemplateRep(DataSource dataSource) {
        db = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(db);
        // 직접 쿼리를 쓸 필요 없이 인서트 문을 만들어준다.
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());
        parameters.put("phone", member.getPhone());
        parameters.put("address", member.getAddress());
        parameters.put("email", member.getEmail());



        // 키를 받아서 id로 세팅한다.
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());

        return member;
    }


    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(db.queryForObject("select * from member where id = ? ", memberRowMapper(), id));
    }

    @Override
    public List<Member> findAll() {

        return db.query("select * from member", memberRowMapper());

    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    @Override
    public void clearmap() {

    }
    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setPhone(rs.getString("phone"));
            member.setAddress(rs.getString("address"));
            member.setEmail(rs.getString("email"));

            return member;
        };
    }
}
