package pl.wsb.fitnesstracker.training.internal;

import io.micrometer.common.lang.Nullable;

public record UserTrainingDto(@Nullable Long id, String firstName, String lastName,
                              String email) {
}
