    package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

    import jakarta.persistence.Column;
    import lombok.Getter;
    import lombok.NonNull;
    import lombok.ToString;

    import jakarta.persistence.Embeddable;


    @Embeddable

    public record Description(
            @NonNull @Column(name = "description") String value
    ) {
        public Description() {
            this(null); // Puedes establecer un valor predeterminado si lo deseas
        }

        // Declarar cualquier otra lógica relacionada con la descripción aquí si es necesario
    }
