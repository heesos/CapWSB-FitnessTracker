package pl.wsb.fitnesstracker.user.internal;

import jakarta.annotation.Nullable;

public record EmailOnlyUserDto(@Nullable Long id, String email) {}