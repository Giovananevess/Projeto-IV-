package safraexpress.safraexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safraexpress.safraexpress.entity.Pedido;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdIn(List<Long> pedidoIds);

    Boolean existsByDescription(String description);
}
