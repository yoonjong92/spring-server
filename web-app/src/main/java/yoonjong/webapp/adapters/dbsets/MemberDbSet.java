package yoonjong.webapp.adapters.dbsets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yoonjong.core.domains.member.models.MemberModel;
import yoonjong.core.domains.member.ports.GetMemberPort;
import yoonjong.core.domains.member.ports.SaveMemberPort;
import yoonjong.database.entities.MemberEntity;
import yoonjong.database.repositories.MemberRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberDbSet implements GetMemberPort, SaveMemberPort {

    private final MemberRepository memberRepository;

    public static MemberModel ToModel(MemberEntity entity) {
        MemberModel model = new MemberModel();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setName(entity.getName());
        model.setPermissionGroupId(entity.getPermission_group_id());
        model.setUpdatedAt(entity.getUpdated_at());
        model.setCreatedAt(entity.getCreated_at());
        return model;
    }

    public static MemberEntity ToEntity(MemberModel model) {
        MemberEntity entity = new MemberEntity();
        entity.setId(model.getId());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setName(model.getName());
        entity.setPermission_group_id(model.getPermissionGroupId());
        entity.setUpdated_at(model.getUpdatedAt());
        entity.setCreated_at(model.getCreatedAt());
        return entity;
    }

    @Override
    public MemberModel GetMember(long id) {
        Optional<MemberEntity> byId = memberRepository.findById(id);
        if(byId.isEmpty())
            return null;

        MemberEntity memberEntity = byId.get();
        return ToModel(memberEntity);
    }

    @Override
    public List<MemberModel> GetAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberDbSet::ToModel)
                .toList();
    }

    @Override
    public MemberModel GetMemberByEmail(String email) {
        Optional<MemberEntity> byEmail = memberRepository.findByEmail(email);
        if(byEmail.isEmpty())
            return null;

        MemberEntity memberEntity = byEmail.get();
        return ToModel(memberEntity);
    }

    @Override
    public long InsertMember(MemberModel member) {
        MemberEntity entity = ToEntity(member);
        entity.setCreated_at(OffsetDateTime.now());
        entity.setUpdated_at(entity.getCreated_at());
        memberRepository.save(entity);
        return entity.getId();
    }

    @Override
    public void DeleteMember(long id) {
        memberRepository.deleteById(id);
    }
}
