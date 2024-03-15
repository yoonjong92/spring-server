package yoonjong.core.domains.member.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.MemberModel;
import yoonjong.core.domains.member.ports.GetMemberPort;
import yoonjong.core.domains.member.ports.SaveMemberPort;
import yoonjong.core.domains.member.usecases.GetMemberUseCase;
import yoonjong.core.domains.member.usecases.SaveMemberUseCase;

@Component
@RequiredArgsConstructor
public class MemberDomainService implements GetMemberUseCase, SaveMemberUseCase {

    private final GetMemberPort getMemberPort;
    private final SaveMemberPort saveMemberPort;

    @Override
    public MemberModel GetMember(long id) {
        return null;
    }

    @Override
    public MemberModel GetMember(String email) {
        return null;
    }

    @Override
    public MemberModel Login(String email, String password) {
        MemberModel model = getMemberPort.GetMemberByEmail(email);
        if(model == null)
            return null;
        if(!model.getPassword().equals(password))
            return null;
        return model;
    }

    @Override
    public MemberModel CreateMember(String email, String password, String name) {
        MemberModel model = new MemberModel();
        model.setEmail(email);
        model.setPassword(password);
        model.setName(name);
        model.setId(saveMemberPort.InsertMember(model));
        return model;
    }
}
