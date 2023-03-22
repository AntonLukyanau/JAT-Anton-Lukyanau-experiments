package org.example.java17.sealedclasses;

public sealed class SealedParent permits FinalSubClass, NonSealedSubClass, SealedSubClass {
}
