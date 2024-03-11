package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.Member;

public interface GetMemberUseCase {
    Member GetMember(long id);
    Member GetMember(String email);
}
