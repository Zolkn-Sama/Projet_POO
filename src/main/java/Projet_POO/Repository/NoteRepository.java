package Projet_POO.Repository;

import Projet_POO.Domain.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


}

