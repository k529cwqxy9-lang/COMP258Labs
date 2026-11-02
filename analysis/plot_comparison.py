from pathlib import Path
import csv
import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt

folder = Path(__file__).resolve().parent
sizes = list(range(1, 1001))
array = [n * (n + 3) // 2 for n in sizes]
linked = [2 * n for n in sizes]

with (folder / "operation-counts.csv").open("w", newline="") as file:
    writer = csv.writer(file)
    writer.writerow(["n", "array_operations", "linked_list_operations"])
    writer.writerows(zip(sizes, array, linked))

plt.rcParams.update({"font.family": "DejaVu Sans", "font.size": 11})
fig, axes = plt.subplots(1, 2, figsize=(11, 4.6))
for ax in axes:
    ax.plot(sizes, array, color="#b44d19", label="array: n(n + 3) / 2", linewidth=2.5)
    ax.plot(sizes, linked, color="#126e82", label="linked list: 2n", linewidth=2.5)
    ax.set_xlabel("collection size (n)")
    ax.set_ylabel("counted operations")
    ax.grid(alpha=0.25)
    ax.legend(loc="upper left", fontsize=9)
axes[0].set_title("Worst case: every item matches")
axes[0].ticklabel_format(axis="y", style="plain")
axes[1].set_xscale("log")
axes[1].set_yscale("log")
axes[1].set_title("Same counts on logarithmic axes")
fig.suptitle("Removing all occurrences: array vs linked list", fontsize=15, fontweight="bold")
fig.text(0.5, 0.015, "Model: one value comparison or one storage update = one operation. Counts are analytical, not timings.", ha="center", fontsize=9)
fig.tight_layout(rect=[0, 0.055, 1, 0.92])
fig.savefig(folder / "comparison.png", dpi=180)
plt.close(fig)
