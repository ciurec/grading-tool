import os
import shutil
import difflib
import glob
import csv
import subprocess

from tabulate import tabulate  # Import tabulate for pretty-printing

# Path to the directory where you want to clone the repositories
STUDENT_REPOS_DIR = 'C:/Users/Catalin Ciurean/Desktop/verificare'
# List of student names and their corresponding GitHub repositories
STUDENT_REPO_MAP = {
    'Bodea Sebastian': 'https://github.com/isp-cluj/isp-2025-hm-sebastian-bodea-30126.git',
    'Bonatiu Alexandru - Sebastian': 'https://github.com/isp-cluj/isp-2025-hm-BonatiuAlex',
    'Ciulavu Paul - Gabriel': 'https://github.com/isp-cluj/isp-2025-hm-MethPaul.git',
    'Dala Andrei - Daniel': 'https://github.com/isp-cluj/isp-2025-hm-dalaandrei.git',
    'Frank Antonia': 'https://github.com/isp-cluj/isp-2025-hm-AntoniaFrank22',
    'Frateanu David - Petru': 'https://github.com/isp-cluj/isp-2025-hm-DPFrateanu',
    'Har Adrian - Gabriel': 'https://github.com/isp-cluj/isp-2025-hm-aditzuAGH.git',
    'Ionica Dan - Cristian': 'https://github.com/isp-cluj/isp-2025-hm-dann911.git',
    'Jircan Alexandra - Stefana - Maria': 'https://github.com/isp-cluj/isp-2025-hm-AlexandraJircan',
    'Knecht Patrik': 'https://github.com/isp-cluj/isp-2025-hm-carnati.git',
    'Luci Razvan - Gabriel': 'https://github.com/isp-cluj/isp-2025-hm-RazvanLuci',
    'Marc Octavia': 'https://github.com/isp-cluj/isp-2025-hm-marcoctavia.git',
    'Mintau Andrei - Catalin': 'https://github.com/isp-cluj/isp-2025-hm-MoNTyZew',
    'Mircea Bogdan - Florin': 'https://github.com/isp-cluj/isp-2025-hm-bogdanmircea10',
    'Moldovan Bianca - Cristina': 'https://github.com/isp-cluj/isp-2025-hm-biancacristinamoldovan',
    'Morosan Sebastian- Vasile': 'https://github.com/isp-cluj/isp-2025-hm-morosan-sebastian-vasile-30126',
    'Morosanu Ioan - Teodor': 'https://github.com/isp-cluj/isp-2025-hm-teodormorosanu',
    'Nagy David - Csaba': 'https://github.com/isp-cluj/isp-2025-hm-Flakon1',
    'Pakot Peter': 'https://github.com/isp-cluj/isp-2025-hm-RockLionIT',
    'Patrascan Ana - Florina': 'https://github.com/isp-cluj/isp-2025-hm-florina01',
    'Robotin Cosmina - Cristiana': 'https://github.com/isp-cluj/isp-2025-hm-cosminarobotin',
    'Teoc Daria - Lavinia': 'https://github.com/isp-cluj/isp-2025-hm-DariaLavinia',
    'Trif Andrei': 'https://github.com/isp-cluj/isp-2025-hm-andrei14trif',
    'Zaharie Alin - Nicolae': 'https://github.com/isp-cluj/isp-2025-hm-BoniiChan',

    # Add more students and their GitHub links here
}
EXCLUDED_PACKAGES = ['demo', 'test']

# Specify the subdirectory (package) you want to check (relative to the root of each repo)
PACKAGE_PATH = 'isp-lab-2-2025-main/src'

# Directory where repositories will be cloned
TEMP_SUBMISSIONS_DIR = 'temp_submissions'


def prepare_submissions():
    if os.path.exists(TEMP_SUBMISSIONS_DIR):
        shutil.rmtree(TEMP_SUBMISSIONS_DIR)
    os.makedirs(TEMP_SUBMISSIONS_DIR)

    for student_name, github_url in STUDENT_REPO_MAP.items():
        repo_name = github_url.rstrip('/').split('/')[-1]
        repo_path = os.path.join(STUDENT_REPOS_DIR, repo_name)

        if os.path.exists(repo_path):
            print(f" Skip pull")
            # uncomment for pulling latest changes
            # print(f"🔄 Pulling latest changes for {student_name}...")
            # try:
            #     subprocess.run(["git", "-C", repo_path, "pull"], check=True)
            # except subprocess.CalledProcessError:
            #     print(f"❌ Failed to pull latest changes for {student_name}, skipping...")
            #     continue
        else:
            print(f"🆕 Cloning repository for {student_name}...")
            try:
                subprocess.run(["git", "clone", github_url, repo_path], check=True)
            except subprocess.CalledProcessError:
                print(f"❌ Failed to clone {github_url}, skipping...")
                continue

        package_path = os.path.join(repo_path, PACKAGE_PATH)

        print(f"🔍 Checking path: {package_path}")

        if not os.path.exists(package_path):
            print(f"❌ Package {PACKAGE_PATH} not found for {student_name}, skipping...")
            continue

        java_files = [
            f for f in glob.glob(os.path.join(package_path, '**', '*.java'), recursive=True)
            if not any(excluded in f for excluded in EXCLUDED_PACKAGES)
        ]

        if not java_files:
            print(f"⚠️ No Java files found for {student_name} after exclusions, skipping...")
            continue

        student_dir = os.path.join(TEMP_SUBMISSIONS_DIR, repo_name)
        os.makedirs(student_dir, exist_ok=True)

        for file in java_files:
            shutil.copy(file, student_dir)

    submission_files = glob.glob(os.path.join(TEMP_SUBMISSIONS_DIR, '**', '*.java'), recursive=True)
    return submission_files


def compare_files(file1, file2):
    with open(file1, 'r', encoding='utf-8') as f1, open(file2, 'r', encoding='utf-8') as f2:
        file1_lines = f1.readlines()
        file2_lines = f2.readlines()

    ratio = difflib.SequenceMatcher(None, file1_lines, file2_lines).ratio()
    return ratio


def detect_duplication(submission_files):
    similarities = []

    for i, file1 in enumerate(submission_files):
        for file2 in submission_files[i + 1:]:
            similarity = compare_files(file1, file2)
            if similarity > 0.7:  # Threshold for considering as similar
                similarities.append((file1, file2, similarity))

    similarities.sort(key=lambda x: x[2], reverse=True)

    return similarities


# Function to get student name from the file path
def get_student_name(file_path):
    repo_name = file_path.split(os.path.sep)[-2]
    for student_name, github_url in STUDENT_REPO_MAP.items():
        if repo_name in github_url:
            return student_name
    return "Unknown"


# Print results in a pretty format
def print_results_pretty(similarities):
    headers = ["Student 1", "Student 2", "File 1", "File 2", "Similarity"]
    table = []

    for similarity in similarities:
        file1, file2, ratio = similarity
        student1 = get_student_name(file1)
        student2 = get_student_name(file2)

        # Extract only the file name
        file1_name = os.path.basename(file1)
        file2_name = os.path.basename(file2)

        table.append([student1, student2, file1_name, file2_name, f"{ratio * 100:.2f}%"])

    print(tabulate(table, headers, tablefmt="pretty"))


def save_results(similarities):
    with open('code_duplication_results.csv', mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['Student 1', 'Student 2', 'File 1', 'File 2', 'Similarity'])

        for similarity in similarities:
            file1, file2, ratio = similarity
            student1 = get_student_name(file1)
            student2 = get_student_name(file2)

            # Extract only the file name
            file1_name = os.path.basename(file1)
            file2_name = os.path.basename(file2)

            writer.writerow([student1, student2, file1_name, file2_name, f"{ratio * 100:.2f}%"])


def run_all():
    submission_files = prepare_submissions()
    print(f"Total submission files prepared: {len(submission_files)}")

    similarities = detect_duplication(submission_files)
    print_results_pretty(similarities)
    save_results(similarities)


if __name__ == '__main__':
    run_all()
