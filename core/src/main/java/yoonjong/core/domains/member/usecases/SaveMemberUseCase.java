package yoonjong.core.domains.member.usecases;

import yoonjong.core.domains.member.models.Member;

public interface SaveMemberUseCase {
    long CreateMember(String email, String password, String name);
}
