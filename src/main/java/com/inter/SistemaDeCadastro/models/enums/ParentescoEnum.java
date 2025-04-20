package com.inter.SistemaDeCadastro.models.enums;

    public enum ParentescoEnum {
        PAI("Pai"),
        MAE("Mãe"),
        AVO("Avô"),
        AVO_MULHER("Avó"),
        TIO("Tio"),
        TIA("Tia"),
        IRMAO("Irmão"),
        IRMA("Irmã"),
        PADRASTO("Padrasto"),
        MADRASTA("Madrasta"),
        GUARDIAO_LEGAL("Guardião Legal"),
        RESPONSAVEL_LEGAL("Responsável Legal"),
        TUTOR("Tutor"),
        CUIDADOR("Cuidador");

        private final String descricao;

        ParentescoEnum(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public static ParentescoEnum from(String value) {
            String normalizado = value.trim().toUpperCase().replace("Ã", "A").replace("Õ", "O").replace("É", "E");
            for (ParentescoEnum p : values()) {
                if (p.name().equals(normalizado)) {
                    return p;
                }
            }
            throw new IllegalArgumentException("Parentesco inválido: " + value);
        }
    }

