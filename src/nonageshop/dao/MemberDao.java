package nonageshop.dao;

import nonageshop.dto.Member;

public interface MemberDao {
	int confirmId(String userId);
	Member getMember(String id);
	int insertMember(Member member);
}
