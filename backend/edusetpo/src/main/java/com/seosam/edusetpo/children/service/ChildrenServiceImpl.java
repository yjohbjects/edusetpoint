package com.seosam.edusetpo.children.service;

import com.seosam.edusetpo.children.dto.ChildrenCreateDto;
import com.seosam.edusetpo.children.entity.Children;
import com.seosam.edusetpo.children.repository.ChildrenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildrenServiceImpl implements ChildrenService{
    private final ChildrenRepository childrenRepository;
    public ChildrenServiceImpl(ChildrenRepository childrenRepository){
        this.childrenRepository = childrenRepository;
    }


    @Override
    public Optional<Long> createChildren(Long parentId, ChildrenCreateDto childrenCreateDto) {
        Children children =toEntity(childrenCreateDto);
        childrenRepository.save(children);
        return Optional.of(children.getChildId());
    }
}
