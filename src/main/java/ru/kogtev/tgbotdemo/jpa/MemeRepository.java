package ru.kogtev.tgbotdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.kogtev.tgbotdemo.model.Meme;

import java.util.UUID;

@Repository
public interface MemeRepository extends JpaRepository<Meme, UUID>, JpaSpecificationExecutor<Meme> {
}
