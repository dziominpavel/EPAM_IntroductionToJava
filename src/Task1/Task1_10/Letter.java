package Task1.Task1_10;

import static Task1.Task1_10.CharType.CONSONANT;
import static Task1.Task1_10.CharType.VOWEL;

public enum Letter {
    A(VOWEL),
    B(CONSONANT),
    C(CONSONANT),
    D(CONSONANT),
    E(VOWEL),
    F(CONSONANT),
    G(CONSONANT),
    H(CONSONANT),
    I(VOWEL),
    J(CONSONANT),
    K(CONSONANT),
    L(CONSONANT),
    M(CONSONANT),
    N(CONSONANT),
    O(VOWEL),
    P(CONSONANT),
    Q(CONSONANT),
    R(CONSONANT),
    S(CONSONANT),
    T(CONSONANT),
    U(VOWEL),
    V(CONSONANT),
    W(CONSONANT),
    X(CONSONANT),
    Y(VOWEL),
    Z(CONSONANT);

    private CharType type;

    Letter(CharType type) {
        this.type = type;
    }

    public CharType getType() {
        return type;
    }
}
